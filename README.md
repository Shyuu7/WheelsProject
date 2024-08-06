A project that was issued by my college professor based on the book "A Student Guide to Object-Oriented Development", by  Carol Britton and Jill Doake.

![image](https://github.com/user-attachments/assets/b54bfc56-5dbf-4e5d-9053-ffaeabcf8c5b)

> The book is an introductory text that follows the software development process, from requirements capture to implementation, using an object-oriented approach. The book uses object-oriented techniques to present a practical viewpoint on developing software, providing the reader with a basic understanding of object-oriented concepts by developing the subject in an uncomplicated and easy-to-follow manner.
The book outlines standard object-oriented modelling techniques and illustrates them with a variety of examples and exercises, using UML as the modelling language and Java as the language of implementation. It adopts a simple, step by step approach to object-oriented development, and includes case studies, examples, and exercises with solutions to consolidate learning.

Our main task was to add a feature into the finalized offered code, which simulated a bike rental shop system. However, more than a couple things bothered me right from the start:
1) All of the variables and values (total price, daily ongoing rate, bike models, etc) were hardcoded and didn't offer any means of updating the data...

    ... which, in a real-world scenario, simply does not work.

2) Because of that, there was no way to receive user inputs and no way to interact with the system.
   
3) In a real-world setting, at least some sort of confirmation would be required at the end of the transaction.

With all of that in mind, I decided to work on polishing a bit of the code.

Firstly, I came up with a simple GUI using Java's Swing, allowing the user to interact with the system.

![image](https://github.com/user-attachments/assets/3f8b2b6a-e264-4882-8169-b48d8d3df0a5)
![image](https://github.com/user-attachments/assets/81b29751-9288-414a-99ea-f7642c87385a)
![image](https://github.com/user-attachments/assets/d9fb3fe3-8284-417b-b4b0-d486d8be77e2)



Secondly, I used Apache PDFBox to create and save a PDF receipt model, so that the user can print it and hand it over to the customer, as a way of keeping track of the transactions. The file is saved into the main root folder.
![image](https://github.com/user-attachments/assets/0df2d25f-e6b1-4876-bada-e0a1a54918f7)
![image](https://github.com/user-attachments/assets/04c1dedb-ac85-4d53-81a0-8230035a2ce2)


Lastly, I decided to add some statistics to the system, so that the store had a way of knowing which was the most rented bike model or the most frequent customer. This is a good business practice cause it allows managers to have a better understanding of their business and how to improve based upon that.
However, at this time the data is only saved locally.


![image](https://github.com/user-attachments/assets/379ee3a6-ccbf-440f-8c35-b2ffd29bbf58)

# To-Do List:

- [ ] Implement SQL database integration



