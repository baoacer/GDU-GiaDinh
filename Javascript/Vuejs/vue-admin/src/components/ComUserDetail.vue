<template>
  <div class="container">
    <h3 class="detail-title">Hồ sơ của tôi</h3>
    <form @submit.prevent="saveProfile">
      <table class="profile-table">
        <tbody>
        <tr>
          <td class="label-info"><label for="fullName">Họ và tên</label></td>
          <td class="info">
            <div>
              <input
                  id="fullName"
                  required
                  type="text"
                  v-model="fullName"
                  placeholder="Họ tên"
                  class="input-info"
              />
            </div>
          </td>
        </tr>

        <tr>
          <td class="label-info"><label for="phoneNumber">Số điện thoại</label></td>
          <td class="info">
            <div>
              <input
                  id="phoneNumber"
                  required
                  type="tel"
                  v-model="phoneNumber"
                  placeholder="Số điện thoại"
                  class="input-info"
              />
            </div>
          </td>
        </tr>

        <tr>
          <td class="label-info"><label for="address">Địa chỉ</label></td>
          <td class="info">
            <div>
              <input
                  id="address"
                  required
                  type="text"
                  v-model="address"
                  placeholder="Địa chỉ"
                  class="input-info"
              />
            </div>
          </td>
        </tr>
        </tbody>
      </table>
      <button class="btn-save" type="submit">Lưu</button>
    </form>
    <router-link to="/order-history" class="btn-order-history">Xem lịch sử đơn hàng</router-link>
  </div>
</template>

<script>
import axios from "axios";
export default
{
  data() {
    return {
      fullName: '',
      phoneNumber: '',
      address: '',
    };
  },
  mounted() {
    this.fetchUserProfile();
  },
  methods: {
    async saveProfile() {
      try {
        const token = localStorage.getItem('accessToken'); // Lấy token từ localStorage
        await axios.put(
            'http://localhost:2999/api/users',
            {
              fullName: this.fullName,
              phoneNumber: this.phoneNumber,
              address: this.address,
            },
            {
              headers: {
                Authorization: `Bearer ${token}`,
              },
            }
        );

        alert('Cập nhật thành công');
        await this.$router.push('/cart');
      } catch (error) {
        alert('Cập nhật thất bại');
      }
    },
    async fetchUserProfile() {
      const token = localStorage.getItem('accessToken');

      try {
        const response = await axios.get(`http://localhost:2999/api/users`, {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        });

        const userData = response.data;
        console.log(response.data)

        // Cập nhật các trường thông tin người dùng
        this.fullName = userData.fullname;
        this.phoneNumber = userData.phoneNumber;
        this.address = userData.address;
      } catch (error) {
        console.error('Error fetching user profile:', error);
      }
    },
  }
};
</script>

<style scoped>
.btn-order-history {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 20px;
  background-color: #28a745;
  color: white;
  border: none;
  border-radius: 4px;
  text-align: center;
  font-size: 16px;
  text-decoration: none;
}

.btn-order-history:hover {
  background-color: #218838;
}
.container {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

.detail-title {
  text-align: center;
  margin-bottom: 20px;
}

.profile-table {
  width: 100%;
  border-collapse: collapse;
}

.label-info {
  text-align: right;
  padding: 10px;
  font-weight: bold;
}

.info {
  padding: 10px;
}

.input-info {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
}

.input-info:focus {
  border-color: #007bff;
  outline: none;
}

.btn-save {
  display: block;
  width: 100%;
  padding: 10px;
  margin-top: 20px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.btn-save:hover {
  background-color: #0056b3;
}
</style>