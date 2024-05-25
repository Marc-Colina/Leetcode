function twoSum(arrayOfNumbers, target) {
  for (let outer = 0; outer < arrayOfNumbers.length; outer++) {
    for (let inner = outer + 1; inner < arrayOfNumbers.length; inner++) {
      if (arrayOfNumbers[outer] + arrayOfNumbers[inner] === target) {
        return [outer, inner];
      }
    }
  }
}

console.log(twoSum([2, 7, 11, 15, 9], 9));
