package com.cssl.icewkment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.icewkment.commin.vo.SquarePageVO;
import com.cssl.icewkment.entity.Square;
import com.cssl.icewkment.entity.User;
import com.cssl.icewkment.mapper.SquareMapper;
import com.cssl.icewkment.mapper.UserMapper;
import com.cssl.icewkment.service.SquareClassService;
import com.cssl.icewkment.service.SquareCommentService;
import com.cssl.icewkment.service.SquareService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@io.swagger.annotations.Api(tags = "后台圈子管理接口")
@RestController
@RequestMapping("/square")
public class SquareController {
    @Autowired
    private SquareMapper squareMapper;

    @Autowired
    private SquareService squareService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SquareClassService squareClassService;

    @Autowired
    private SquareCommentService squareCommentService;

    @ApiOperation(value = "根据别名获取全部圈子(分页)")
    @ApiImplicitParam(name = "otherName", value = "otherName", required = true)
    @GetMapping("/getAllSquare/{otherName}/{page}/{limit}")
    public SquarePageVO getAllArticle(
            @PathVariable("otherName") String otherName,
            @PathVariable("page") Integer page,
            @PathVariable("limit") Integer limit) {
        return squareService.VoList(otherName, page, limit);
    }

    @ApiOperation(value = "根据id删除圈子")
    @ApiImplicitParam(name = "id", value = "文章id", required = true)
    @GetMapping("/DelectSquareById/{id}")
    public boolean DelectSquareById(
            @PathVariable("id") Integer id
    ) {
        //根据id删除
        QueryWrapper<Square> wrapper = new QueryWrapper<Square>();
        wrapper.eq("id", id);
        squareMapper.delete(wrapper);
        return this.squareService.removeById(id);
    }

    @ApiOperation(value = "根据id修改圈子内容")
    @ApiImplicitParam(name = "id", value = "文章id", required = true)
    @GetMapping("/ChangeSquareById/{id}/{content}")
    public Integer ChangeSquareById(
            @PathVariable("id") Integer id,
            @PathVariable("content") String content
    ) {
        Square square = new Square();
        square.setContent(content);
        QueryWrapper<Square> wrapper = new QueryWrapper<Square>();
        wrapper.eq("id", id);
        return squareMapper.update(square, wrapper);
    }

    @ApiOperation(value = "获取全部圈子用户")
    @GetMapping("/GetAllSquareUser")
    public List<User> GetAllSquareUser() {
        return userMapper.selectList(null);
    }
}
