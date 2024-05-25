function linear_search(arrayOfNumbers, value) {
  let index = 0;
  for (let num of arrayOfNumbers) {
    if (value === num) return index;
    index++;
  }

  return "Value does not exist!";
}

console.log(linear_search([1, 2, 3, 4, 5], 4));
console.log(linear_search([1, 2, 3, 4, 5], 6));
