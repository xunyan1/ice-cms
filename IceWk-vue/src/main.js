import Vue from 'vue'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import '@/styles/index.scss' // global css

import App from './App'
import store from './store'
import router from './router'

import '@/icons' // icon
import '@/permission' // permission control
import VueQriously from 'vue-qriously'

import { getSetting } from '@/api/websetting'

import SlideVerify from 'vue-monoplasty-slide-verify';

Vue.use(SlideVerify);
Vue.use(ElementUI);

Vue.config.productionTip = false

Vue.use(VueQriously)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

// 请求接口保存全局数据
const  getUpdateList = (async()=>{
    await getSetting().then(resp => {   
      store.dispatch("glabledata",resp.data);
    })
})
getUpdateList()

import "element-ui/packages/theme-chalk/lib/base.css";
import "element-ui/packages/theme-chalk/lib/collapse.css";
import "element-ui/packages/theme-chalk/lib/collapse-item.css";
import "element-ui/packages/theme-chalk/lib/select.css";
import "element-ui/packages/theme-chalk/lib/option.css";
