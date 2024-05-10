function sumAndProduct(arrayOfNumbers) {
  let sum = 0;
  let product = 1;
  for (let number of arrayOfNumbers) {
    sum += number;
  }

  for (let number of arrayOfNumbers) {
    product *= number;
  }

  console.log("Sum is : " + sum);
  console.log("Product is : " + product);
}

sumAndProduct([1, 3, 5, 4, 6, 1, 2, 51]);
