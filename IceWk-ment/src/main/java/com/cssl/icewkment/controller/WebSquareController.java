package com.cssl.icewkment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.commin.vo.SquarePageVO;
import com.cssl.icewkment.commin.vo.SquareVO;
import com.cssl.icewkment.entity.Square;
import com.cssl.icewkment.entity.SquareClass;
import com.cssl.icewkment.entity.User;
import com.cssl.icewkment.mapper.SquareMapper;
import com.cssl.icewkment.mapper.UserMapper;
import com.cssl.icewkment.service.SquareClassService;
import com.cssl.icewkment.service.SquareCommentService;
import com.cssl.icewkment.service.SquareService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@io.swagger.annotations.Api(tags = "Web圈子广场接口")
@RestController
@RequestMapping("/Websquare")
public class WebSquareController {

    @Autowired
    private SquareMapper squareMapper;

    @Autowired
    private SquareService squareService;

    @Autowired
    private SquareClassService squareClassService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SquareCommentService squareCommentService;

    @ApiOperation(value = "新增圈子")
    @ApiImplicitParam(name = "square", value = "圈子对象", required = true)
    @PostMapping("/create/{SortName}")
    public Integer add(
            @RequestBody Square square,
            @PathVariable("SortName") String SortName

    ) throws ParseException {
//        查询分类名称对应的id值
        QueryWrapper<SquareClass> wrapper = new QueryWrapper<SquareClass>();
        wrapper.eq("other_name", SortName);
        SquareClass squareClass = squareClassService.getOne(wrapper);
        square.setSortClass(squareClass.getId());
        //saveOrUpdate:要在插入数据库时，如果有某一个主要字段的值重复，则不插入，否则则插入！
        squareService.save(square);
        return square.getId();
    }

    @ApiOperation(value = "评论点赞")
    @ApiImplicitParam(name = "id", value = "评论id", required = true)
    @GetMapping("/likeClickComment/{id}")
    public Boolean likeClickComment(
            @PathVariable("id") Integer id
    ) {
        return squareMapper.resourceLoveBrowse(id);
    }

    @ApiOperation(value = "根据id获取圈子内容")
    @ApiImplicitParam(name = "id", value = "圈子id", required = true)
    @GetMapping("/getSquareById/{id}")
    public SquareVO getSquareById(
            @PathVariable("id") Integer id
    ) {
        Square square = squareMapper.selectById(id);
        //根据用户id获取名称信息
        //id是内容发布者id
        Integer authors = square.getAuthor();
        User users = userMapper.searchId(authors);
        String username = users.getName();
        String authorImg = users.getProfile();
        SquareVO squareVO = new SquareVO();
        squareVO.setAuthor(username);
        squareVO.setUserid(authors);
        squareVO.setAuthorImg(authorImg);
        //查询分类名称对应的id值
        SquareClass SquareClassIs = squareClassService.getById(square.getSortClass());
        squareVO.setSortName(SquareClassIs.getName());

        Integer planetCommentNum = squareCommentService.GetCommentNum(square.getId());
        squareVO.setCommentNum(planetCommentNum);

        BeanUtils.copyProperties(square, squareVO);

        return squareVO;
    }

    @ApiOperation(value = "根据别名获取全部圈子(分页)")
    @ApiImplicitParam(name = "otherName", value = "otherName", required = true)
    @GetMapping("/getAllSquare/{otherName}/{page}/{limit}")
    public SquarePageVO getAllArticle(
            @PathVariable("otherName") String otherName,
            @PathVariable("page") Integer page,
            @PathVariable("limit") Integer limit
    ) {

        return squareService.VoList(otherName, page, limit);
    }
}
