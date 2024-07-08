import * as VueRouter from 'vue-router';
import chat from '../views/ChatView.vue';
import logins from '../views/HelloWorld.vue';
import CGroup from "@/components/card/CGroup.vue";


const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes:[
        {path:'/',redirect:'/Logins'},
        {path:'/Logins',component:logins,meta: { noTransition: true }},
        {path:'/Chat',
            name:'user',
            component:chat,
            meta: { requiresAuth: true }
        },
        {
            path:'/cgroup',
            name:'CGroup',
            component:CGroup,
        }
    ]
});

//Router守卫
// router.beforeEach((to, from, next) => {
//     // 检查用户是否已登录
//     const loggedIn = !!localStorage.getItem('userid'); // 检查 localStorage 中是否有 'user' 项来判断用户是否已登录
//
//     // 如果目标路由需要认证并且用户未登录
//     if (to.matched.some(record => record.meta.requiresAuth) && !loggedIn) {
//         next('/Logins'); // 重定向到登录页面
//     } else {
//         next(); // 继续跳转到目标路由
//     }
//
// });

export default router;
