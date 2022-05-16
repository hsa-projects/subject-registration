#BPMN Tutorial
##BPMN
**[BPMN](https://www.bpmn.org/)** is a standard for business process modeling that provides a graphical notation for specifying business processes in a Business Process Diagram.
That modelling language has a huge advantage. It can be used either good by techies or people that don't have IT background. That's why is BPMN as an interface between developers, process analysts and casual employees or stakeholders.
###Syntax
BPMN includes a lot of elements to show a flow of process, but there are most used of them. To see the list of existing elements click [here](http://www.bpmb.de/images/Poster_en.png).
##Tools
To use advantages of BPMN graphical toolset is needed. There are a lot of graphical editors. It is very important the toolchain contains all the most needed elements. 
The model itself is just a way to show some process in high standardized way,that could be understood by different user groups. Nowadays we have also the opportunity to simulate BPMN models. For those simulations we need to use BPMN Engine. In this case it would be useful to have an universal software,that includes all the needed modules. The solution is [**Camunda**](https://camunda.com/).
##Model
The whole project includes two different BPMN models: 
![Model](registration_window.png)


This project includes more than one BPMN model, but we will use "Subject registration" as an example (see beelow).&nbsp;
&nbsp;
![Model](subject_registration.png)
This model includes 3 Activity objects:
- Update subject
- Confirm results
- Execute cancel registration

2 Events:
- Register window timeout
- results available

2 boundary events:
- Cancel Register
- Results confirmation timeout

8 sequence flows
###Activity
>An Activity is represented by a rounded-corner rectangle (see the figure to the right) and is a generic term for work that the company performs. An Activity can be atomic or nonatomic (compound). The types of Activities are Task and Sub-Process. The Sub-Process is distinguished by a small plus sign in the bottom center of the shape.

There are different types of Activities(also known tasks). In the given model we have "user task" and "service task".

"User tasks" shows that some action will be done by user manually. 

"Service task" shows that some action will be done by using of some program. It is very important in case, if modeller is going to implement some business logic for the task. 
###Events
>An event is a common Business Process Model and Notation (BPMN) 
>process modeling element that represents something that “happens” during the course of a process. In BPMN, events are expressed as circles. Events indicate when some event occurs at the start, end or during a process (as opposed to when some task or activity is performed)

More ifnormation [here](https://www.visual-paradigm.com/guide/bpmn/bpmn-events/)

###Sequence Flow

>A Sequence Flow is represented by a solid line with a solid arrowhead (see the figure to the right) and is used to show the order (the sequence) that activities will be performed in a Process. Note that the term “control flow” is generally not used in BPMN

##Scenario of the given model 
The given model is complicated, because it includes two groups of processes. At first student has to enter subjects to registrate . He can also update the status of registration throw adding of new registrations or cancellation of a registration. Since the registration time exrpired the results will be avaliable and the student can confirm the registration for a subject. If confiramtion step expired student has no more oportunity to confirm or cancel assigned subjects.
####Update subjects
Student chooses desired subjects. Student can also delete a registration for a subject. In this case "Cancel Registration" event would be triggered.
####Cancel Registration
After this event triggers follows it to an activity "Execute cancel registration"
####Execute cancel registration
This service task executes business logic for subject cancelation and finished the entire process chain.
####Register window timeout
If given time for registration expires, it will be triggered window timeout event. It means, that there are no more opportunity for a student to registrate himself for a subject. 
####Results available
After registration time expires, business logic computes and analyze students data and generates results. After computing finishes, students can get their results of a registration.
####Confirm results
The given subjects can be confirmed oder canceled. 
####Results confirmation timeout.
After time for the confirmation expires it isn't possible to make any changes for a given results. 