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
            component:chat
        }
    ]
})

export default router;
