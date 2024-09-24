let arrayProduct = [
  { name: "Cam", price: 1000 },
  { name: "Táo", price: 5000 },
  { name: "Bưởi", price: 3000 },
  { name: "Quýt", price: 1500 },
  { name: "Dưa", price: 800 },
];

let flag = -1;
let ul = document.getElementById("product-list");

document.addEventListener("DOMContentLoaded", () => {
  const renderProduct = (arrayProduct) => {
    ul.innerHTML = "";
    arrayProduct.forEach((product) => {
      let { name, price } = product;
      let li = document.createElement("li");
      li.innerHTML = `<span class="product-name">${name}</span><span>${price}</span>`;
      ul.appendChild(li);
    });
  };

  
  const sort = document.getElementById("sort-btn");
  
  const filter = document.getElementById("filter-price");
  filter.addEventListener("input", () => {
    debugger;
    let priceInput = document.getElementById("filter-price").value;
    let newArray = arrayProduct;
    if (priceInput != "") {
      if (flag == -1) {
        newArray = arrayProduct.filter((product) => product.price < priceInput);
      }
    }
    renderProduct(newArray);
    
    sort.addEventListener("click", () => {
      debugger;
      if (flag == -1) {
        newArray.sort((a, b) => a.price - b.price);
        flag = 1;
      } else {
        newArray.sort((a, b) => b.price - a.price);
        flag = -1;
      }
      renderProduct(newArray);
    });
  });
  
  sort.addEventListener("click", () => {
    debugger;
    let newArray = arrayProduct;
    if (flag == -1) {
      newArray.sort((a, b) => a.price - b.price);
      flag = 1;
    } else {
      newArray.sort((a, b) => b.price - a.price);
      flag = -1;
    }
    renderProduct(newArray);
  });

  renderProduct(arrayProduct);
})


