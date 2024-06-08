<template>
  <body>
  <div class="container">
    <span></span>
    <span></span>
    <span></span>
    <form v-if="!isSignUp" @submit.prevent="signIn" id="sign_in_Form">
      <h2>Login</h2>
      <div class="inputBox">
        <input type="text" v-model="loginUsername" placeholder="Username">
      </div>
      <div class="inputBox">
        <input type="password" v-model="loginPassword" placeholder="Password">
      </div>
      <div class="inputBox group">
        <a href="#">Forget Password</a>
        <a href="#" @click="toggleSignUp">Sign up</a>
      </div>
      <div class="inputBox">
        <input type="submit" value="Sign in">
      </div>
    </form>

    <form v-else @submit.prevent="signUp" id="sign_up_Form">
      <h2>Registration</h2>
      <div class="inputBox">
        <input type="text" v-model="signupUsername" placeholder="Username">
      </div>
      <div class="inputBox">
        <input type="password" v-model="signupEmail" placeholder="Email Address">
      </div>
      <div class="inputBox">
        <input type="password" v-model="signupPassword" placeholder="Create Password">
      </div>
      <div class="inputBox">
        <input type="password" v-model="confirmPassword" placeholder="Confirm Password">
      </div>
      <div class="inputBox">
        <input type="submit" value="Register Account">
      </div>
      <div class="inputBox group">
        <a href="#">Already Have an Account ?
          <b @click="toggleSignUp">Login</b>
        </a>
      </div>
    </form>
  </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  name: "HelloWorld",
  data() {
    return {
      isSignUp: false,
      loginUsername: '',
      loginPassword: '',
      signupUsername: '',
      signupEmail: '',
      signupPassword: '',
      confirmPassword: ''
    }
  },
  methods: {
    toggleSignUp() {
      this.isSignUp = !this.isSignUp;
      if (this.isSignUp) {
        document.body.classList.add('signup');
      } else {
        document.body.classList.remove('signup');
      }
    },

    signIn: function () {
      if(this.loginUsername === '') {
        alert("Please enter your name");
        return;
      }
      if(this.loginPassword === ''){
        alert("Please enter your password");
        return;
      }

      // 发送登录请求
      axios.post('http://127.0.0.1:8088/api/login', {
        username: this.loginUsername,
        password: this.loginPassword
      })
          .then(response => {
            if (response.status === 200) {
              window.alert("Successfully Login");
              this.$router.push('/Chat' + "/" + this.loginUsername);
            } else window.alert(response.message);
            // 登录成功处理逻辑
            console.log(response);

          })
          .catch(error => {
            window.alert("An error occurred while logging in");
            // 处理登录失败逻辑
            console.error(error);
          });
    },

    signUp: function () {
      if(this.signupUsername === '') {
        alert("Please enter your name");
        return;
      }
      if(this.signupEmail === '') {
        alert("Please enter your email address");
        return;
      }
      if(this.signupPassword === '') {
        alert("Please enter your password");
        return;
      }
      if(this.confirmPassword !== this.signupPassword) {
        alert("confirm Password must match");
        return;
      }

      // 发送注册请求
      axios.post('http://127.0.0.1:8088/api/register', {
        username: this.signupUsername,
        email: this.signupEmail,
        password: this.signupPassword,
        confirmPassword: this.confirmPassword
      })
          .then(response => {
            if(response.status === 200){
              window.alert("Successfully Register");
              this.toggleSignUp();
            }
            else window.alert(response.message);
            // 注册成功处理逻辑
            console.log(response);

          })
          .catch(error => {
            window.alert("An error occurred while registering in");
            // 处理注册失败逻辑
            console.error(error);
          });
    }
  },

}
</script>

<style scoped>
/* Add your CSS styles here */
*
{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
body
{
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}
body::before
{
  content: '';
  position: absolute;
  inset: 0;
  background: url("https://img.zcool.cn/community/019ead5da989b5a801209e1f598699.jpg@2o.jpg");
  background-attachment: fixed;
  background-size: cover;
  background-position: center;
}
body::after
{
  content: '';
  position: absolute;
  inset: 0;
  background: url("https://ts1.cn.mm.bing.net/th/id/R-C.9de21ce1a0a20bb383a9585e3f3125c5?rik=zGlgCJpZFwM%2bRA&riu=http%3a%2f%2fbpic.588ku.com%2fback_pic%2f05%2f78%2f10%2f585bfbaca942732.jpg&ehk=MawbNDC1hm%2f5Zh8DE0IlF5OwQMY73sI2spjiootDV%2b0%3d&risl=&pid=ImgRaw&r=0");
  background-attachment: fixed;
  background-size: cover;
  background-position: center;
  opacity: 0;
  transition: 0.5s;
}
body.signup::after
{
  opacity: 1;
}
.container
{
  position: relative;
  width: 350px;
  height: 350px;
  border-radius: 15px;
  box-shadow: 0 5px 25px rgba(0,0,0,0.25);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
  transition: 0.5s;
  overflow: hidden;
}
body.signup .container
{
  height: 440px;

}
.container::before
{
  content: '';
  position: absolute;
  width: 100%;
  height: 100%;
  background: repeating-conic-gradient(from var(--a),#45f3ff 0%,
  #45f3ff 10%,transparent 10%,transparent 80%,#45f3ff 100%);
  border-radius: 20px;
  animation: animate 2.5s linear infinite;

}
body.signup .container::before
{
  filter: hue-rotate(140deg);
}
@property --a {
  syntax: '<angle>';
  inherits: false;
  initial-value: 0deg;
}
@keyframes animate
{
  0%
  {
    --a:0deg
  }
  100%
  {
    --a:360deg
  }
}
.container span
{
  position: absolute;
  inset: 5px;
  overflow: hidden;
  border-radius: 15px;
}
.container span::before
{
  content: '';
  position: absolute;
  inset: 5px;
  background: url("https://img.zcool.cn/community/019ead5da989b5a801209e1f598699.jpg@2o.jpg");
  background-size: cover;
  background-position: center;
  filter: blur(10px);
}
.container span::after
{
  content: '';
  position: absolute;
  inset: 5px;
  background: url("https://img.zcool.cn/community/019ead5da989b5a801209e1f598699.jpg@2o.jpg");
  background-size: cover;
  background-position: center;
  filter: blur(15px);
}
body.signup .container span::before,
body.signup .container span::after
{
  background: url("https://ts1.cn.mm.bing.net/th/id/R-C.9de21ce1a0a20bb383a9585e3f3125c5?rik=zGlgCJpZFwM%2bRA&riu=http%3a%2f%2fbpic.588ku.com%2fback_pic%2f05%2f78%2f10%2f585bfbaca942732.jpg&ehk=MawbNDC1hm%2f5Zh8DE0IlF5OwQMY73sI2spjiootDV%2b0%3d&risl=&pid=ImgRaw&r=0");
  background-size: cover;
  background-position: center;
  filter: blur(15px);
}
form
{
  position: absolute;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
  gap:15px;
  transition: 0.5s;
}
form#sign_up_Form
{
  left: 100%;
}
body.signup form#sign_in_Form
{
  left: -100%;

}
body.signup form#sign_up_Form
{
  left: 0%;

}

form h2
{
  position: relative;
  color: #fff;
  font-size: 1.5em;
  letter-spacing: 0.1em;
  text-transform: uppercase;
  font-weight: 500;
  margin-bottom: 10px;
}
form .inputBox
{
  position: relative;
  width: 70%;
  display: flex;
  justify-content: space-between;
}
form .inputBox a
{
  color: #fff;
  text-decoration: none;
  font-size: 0.85em;
}
form .inputBox a:nth-child(2)
{
  text-decoration: underline;

}
form .inputBox input
{
  width: 100%;
  outline: none;
  border: 1px solid rgba(255, 255, 255, 0.25);
  background: rgba(0, 0, 0, 0.15);
  padding: 6px 15px;
  border-radius: 4px;
  color: #fff;

}
form .inputBox input::placeholder
{
  color: rgba(255, 255, 255, 0.5);

}
form .inputBox input[type="submit"]
{
  background: #2196f3;
  font-width: 500;
  cursor: pointer;

}
form#sign_up_Form .inputBox input[type="submit"]
{
  background: #f4242f;
  font-width: 500;
  cursor: pointer;

}
form#sign_up_Form b
{
  font-weight: 500;
  color: #ffeb3b;
  text-decoration: underline;
}




</style>
