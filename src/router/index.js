import * as VueRouter from 'vue-router';
import chat from '../views/ChatView.vue';
import logins from '../views/HelloWorld.vue';


const router = VueRouter.createRouter({
    history: VueRouter.createWebHistory(),
    routes:[
        {path:'/',redirect:'/Logins'},
        {path:'/Logins',component:logins},
        {path:'/Chat/:id',
            name:'user',
            component:chat,
            meta: { requiresAuth: true }
        }
    ]
});

//Router守卫
router.beforeEach((to, from, next) => {
    // 检查用户是否已登录
    const loggedIn = !!localStorage.getItem('user'); // 检查 localStorage 中是否有 'user' 项来判断用户是否已登录

    // 如果目标路由需要认证并且用户未登录
    if (to.matched.some(record => record.meta.requiresAuth) && !loggedIn) {
        next('/Logins'); // 重定向到登录页面
    } else {
        next(); // 继续跳转到目标路由
    }
    // if (to.matched.some(record => record.meta.requiresAuth)) {
    //     // 获取 localStorage 中的 users 数组
    //     const users = JSON.parse(localStorage.getItem('users')) || [];
    //
    //     // 遍历 users 数组中的每个对象，检查是否有匹配的用户名
    //     const userLoggedIn = users.some(user => user.username === loggedIn);
    //
    //     if (!userLoggedIn) {
    //         next('/Logins'); // 重定向到登录页面
    //     } else {
    //         next(); // 继续跳转到目标路由
    //     }
    // } else {
    //     next(); // 继续跳转到目标路由
    // }
});

export default router;
