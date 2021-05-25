# Build & Run Instructions
The folder should contains 4 files; Main, Anagram, TestMain & Anagram Test.
## For windows (compilation):
1- Open your cmd in the folder where the files are located.
2- Run the command: javac Main.java Anagram.java
3- Run the command: java Main
## For windows compilation (run Test):
Download the Junit jar file: https://junit.org/junit4/ or use the one provided
1- Open your cmd in the folder where the files are located.
2- set the classpath. You could use this: set CLASSPATH=%CLASSPATH%;<Root directory>\junit-4.8.1.jar;C:\<Root directory>
2- Run the command: javac TestMain.java
3- Run the command: java TestMain

# ALGORITHM
This section explains the algorithm used for the assignment
1. HashMap result <- new HashMap
2. reader <- Read file.
3. if (reader contains file):
4.    while(string/text is in file):
5.        data <- text.toLowerCase.replace(all char except a-z)
6.        HashMap characterMap <- new HashMap
7.        forEach char in data:
8.          if characterMap.hasKey(char)
              characterMap.key(char) <- characterMap.Value(char) + 1
9.          otherwise
              characterMap.add(char, 1)
10.       if result.hasKey(data.length)
11.         if result.get(data.length).hasKey(characterMap)
              result.get(data.length).get(characterMap).add(data)
            otherwise
              list <- new ArrayList
              list.add(data)
              result.get(data.length).add(characterMap, list)
          otherwise
            list <- new ArrayList
            list.add(data)
            HashMap innerMap <- new HashMap
            innerMap.add(characterMap, list)
            result.add(data.length, innerMap)

# HOW DO I VERIFY MY SOLUTION?
I created a Unit Test class. The Test class runs Anagram test for all Even numbers less than half of the size of the outerMap.
To illustrate:
Assuming: Tree, Race, Bee, Care, Acre ... as the words...
The result would look like: {3:{{b:1, e:2}: [Bee]}, 4:{{{t:1, r:1, e:2}: [Tree], {r:1 , a:1, c:1, e:1}: [Race], {c:1, a:1, r:1, e:1}: [Care, Acre]} ... }

- Assummin size of result is 20 (keys 3 through 20)
- the Test would run only on the first 20/2 = 10 indices taking only even numbers: 2, 4, 6, 8 & 10.
- If all tests are passed, it returns true.

# HOW COMPLEX IS YOUR PROGRAM?
Assuming the file contains Z words and each word has a maximum of N characters. The upper bound complexity for time  is approximately O(ZM). Upper bound for space is approx. O(Z+M/2)

On large datasets, the impact would mostly be as a result of Z (number of words). This relationship to Z is linear for both time and space complexity. The algorithm should perform relatively well on large datasets.

# Large input file and only limited memory
The program needs enough memory for storing (hashmap) the data and characters in the dataset. Having a linear relationship, the performance wouldnt be great.

currently, the program:
- reads through each line of data in the file rather than reading the entire file at once. This should be ideal.

Possible improvement:
- Since the goal is to print out the Anagram, one could avoid saving the results in ArrayList or HashMaps. Instead printing out to the console directly at each loop might be better. It could cost a little bit more in time but would save enough memory.
- Another could be (if the original dataset can be modified), writing back to the original file. You could read in sections (say 50 lines), and then replace the result (Anagram) in the original file before proceeding to the next.
- Another possible fix could be working with characters instead of string. This would result in more complexity is code but should reduce the amount on memory needed.
