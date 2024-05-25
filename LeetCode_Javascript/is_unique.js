function is_unique(arrayOfNumbers) {
  for (let outer = 0; outer < arrayOfNumbers.length; outer++) {
    for (let inner = outer + 1; inner < arrayOfNumbers.length; inner++) {
      arrayOfNumbers[outer] === arrayOfNumbers[inner];
      if (arrayOfNumbers[outer] === arrayOfNumbers[inner]) {
        return false;
      }
    }
  }
  return true;
}

function is_unique_set(nums) {
  let set = new Set();

  for (let num of nums) {
    if (set.has(num)) {
      return false;
    } else {
      set.add(num);
    }
  }
  return true;
}

console.log(is_unique([4, 1, 2, 3, 4, 5, 6]));
console.log(is_unique_set([10, 1, 2, 3, 4, 5, 6]));
