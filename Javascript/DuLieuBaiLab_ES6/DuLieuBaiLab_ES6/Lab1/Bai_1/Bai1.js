document.getElementById('registrationForm').addEventListener('submit', (event) => {
    event.preventDefault();
    debugger
    const password = document.getElementById('password').value;
    const retryPassword = document.getElementById('confirmPassword').value;
    
    if(password !== retryPassword) {
        document.getElementById('message').innerHTML = `Mật khẩu không khớp`;
    }else{
        document.getElementById('message').innerHTML = `Đăng ký thành công`;
        document.getElementById('message').style.color = `green`;
        // Chuyển hướng sang trang khác sau khi đăng ký thành công
        window.location.href = './Bai2.html'
       
    }
})