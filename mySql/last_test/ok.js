// trigger spl
  
  function Product(product_name,product_price,product_brand,product_count){
   this.name=product_name,
   this.price=product_price,
   this.brand=product_brand,
   this.count=product_count
  }
  let product=new Product("iphone pro",20000,'apple',3)
  let product1=new Product("samsung",20000,'samsung',7)
  let product2=new Product("xiaomi",20000,'xiaomi',8)
  let product3=new Product("viettel",20000,'viettel',3)
  let products=[product,product1,product2,product3]
  function print_product_list(product_arr){
    for (product of product_arr)
      console.log(`     ${product.name} - ${product.price} - ${product.brand} - ${product.count}`)
  }

  function  total_price(product_list){
    return product_list.reduce((total_money,product)=> total_money+(product.price*product.count),0)
  }
  function filter_by_brand(product_list,brand){
    return product_list.filter(product =>product.brand=brand)
  }
  function filter_by_price(product_list,price){
    return product_list.filter(pro =>pro.price > 20000)
  }
  function filter_by_name(product_list,name){
    return product_list.filter(pro => pro.name.includes(name))
  }
  function add_element(product_list, product_item){
    return product_list.push(product_item)
  }
  function remove_by_brand(product_list, brand){
	return product_list.filter(product => !product.brand===brand)
  }
  function get_random_products(product_list,number){
    return product_list.sample(2)
  }
  console.log("1. List products: ")
print_product_list(products)
console.log(`2. Total price: ${total_price(products)}`)
console.log("3. List product of Apple: ")
print_product_list(filter_by_brand(products, "Apple"))
console.log("4. List product have price is bigger than 20000000")

print_product_list(filter_by_price(products, 20000000))
console.log("5. List product have name contain 'pro'")
print_product_list(filter_by_name(products, 'pro'))
const product5 = new Product("Samsung S22 ultra", 3200000, "Samsung", 5)
products = add_element(products, product5)
console.log("6.List products after adding product 5")
print_product_list(products)

console.log("7. List products that brand not samsung")
print_product_list(remove_by_brand(products, "Samsung"))

console.log("8. List products order by price ASC")
products.sort((a,b)=> a.price-b.price)
print_product_list(products)

console.log("9. List products order by count DESC")
products.sort((a,b)=> b.count-a.count)
print_product_list(products)

console.log("10. get random 2 product in product list")
print_product_list(get_random_products(products, 2))

  