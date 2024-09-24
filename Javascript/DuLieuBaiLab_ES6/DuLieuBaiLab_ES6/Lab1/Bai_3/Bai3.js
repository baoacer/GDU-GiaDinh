document.addEventListener("DOMContentLoaded", () => {
  const products = [
    { name: "Vũ Express", price: "500,000 VDN", description: "1M7, 50kg" },
    { name: "Trường Neovim", price: "500,000 VDN", description: "1M7, 52kg" },
    { name: "Hoàng design", price: "500,000 VDN", description: "1M7, 70kg" },
    { name: "Bảo Java", price: "500,000 VDN", description: "1M7, 52kg" },
  ];

  const productList = document.getElementById("product-list");
  const nameElement = document.querySelector(`.name`);
  const priceElement = document.querySelector(`.price`);
  const descriptionElement = document.querySelector(`.description`);
  products.forEach((product, index) => {
    // create tag `li`
    const li = document.createElement("li");
    // gan gia tri cho tag `li`
    let { name } = product;
    li.textContent = name;
    // gan li vao ul;
    productList.appendChild(li);
    // click vào li xuất thông tin chi tiết sản phẩm
    li.addEventListener('click', () => {
        let {name, price, description} = products[index];
        nameElement.innerHTML = name;
        priceElement.innerHTML = price;
        descriptionElement.innerHTML = description;
    });
  });

 
});
