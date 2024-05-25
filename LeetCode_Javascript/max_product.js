function max_product(arrayOfNumbers) {
  let biggestNum = 0;
  let secondBiggestNum = 0;

  for (let num of arrayOfNumbers) {
    if (num > secondBiggestNum) {
      if (num > biggestNum) {
        let temp = biggestNum;
        biggestNum = num;
        secondBiggestNum = temp;
      } else {
        secondBiggestNum = num;
      }
    }
  }
  return biggestNum * secondBiggestNum;
}

console.log(max_product([20, 10, 30, 50, 40, 50]));
