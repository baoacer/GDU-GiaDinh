<template>
  <div class="container">
    <h1>Đăng Nhập</h1>
    <form id="registrationForm" @submit.prevent="handleLogin">
      <label for="email">Email</label>
      <input type="email" id="email" v-model="email" required />

      <label for="password">Mật khẩu</label>
      <input type="password" id="password" v-model="password" required />
      <button type="submit">Đăng nhập</button>
      <div id="message">{{ message }}</div>
    </form>
    <p>Bạn chưa có tài khoản?</p>
    <p>Chưa có tài khoản? <router-link to="/signup">Đăng ký ngay</router-link></p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      email: '',
      password: '',
      message: '',
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await axios.post('http://localhost:2999/api/auth/login', {
          email: this.email,
          password: this.password,
        });

        const { accessToken, refreshToken, userId } = response.data;

        // Lưu trữ token vào localStorage
        localStorage.setItem('accessToken', accessToken);
        localStorage.setItem('refreshToken', refreshToken);
        localStorage.setItem('userId', userId);
        localStorage.setItem('userEmail', this.email);

        // Kiểm tra userId và điều hướng đến trang admin nếu userId = 1
        if (userId === 1) {
          await this.$router.push('/admin'); // Đường dẫn đến trang admin
        } else {
          await this.$router.push('/'); // Đường dẫn đến trang chính
        }

      } catch (error) {
        // Kiểm tra xem lỗi có phải do phản hồi từ API không
        if (error.response) {
          // Nếu có phản hồi từ server
          if (error.response.status === 401) {
            this.message = 'Email hoặc mật khẩu không chính xác.';
          } else {
            // Các lỗi khác từ server
            this.message = error.response.data.message || 'Đăng nhập thất bại. Vui lòng thử lại.';
          }
        } else {
          // Nếu không có phản hồi từ server
          this.message = 'Có lỗi xảy ra. Vui lòng kiểm tra kết nối mạng.';
        }
        console.error('Login failed:', error);
      }
    },
  },
};
</script>

<style scoped>
body {
  font-family: Mulish, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container {
  width: 80%;
  max-width: 400px;
  background: #fff;
  padding: 20px;
  margin: 0 auto;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h1 {
  text-align: center;
  color: #333;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  text-align: left;
  margin-top: 10px;
  color: #333;
}

input {
  padding: 10px;
  margin-top: 5px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button {
  margin-top: 20px;
  padding: 10px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 5px;
  font-size: 1em;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}

#message {
  margin-top: 20px;
  text-align: center;
  font-size: 1em;
  color: red;
}

</style>
