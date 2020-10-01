# User Guide
Duke is an offline application created with Java that allows users to keep track of tasks that they need 
to complete. Duke is run from the command line.
## Features 

### 1. Add A New Task
Users are able to add new tasks. Three types of tasks are supported:

1. *Todo* - these tasks only have a description
2. *Deadline* - these tasks have a description as well as a date the task should be completed by
3. *Event* - these tasks have a description and a date that the event will take place

####Todo Tasks
Format for *Todo* tasks: 

`todo (description)`

Example of *Todo* usage:

`todo deliver parcel`

Expected outcome:

    Ok! I've added the following task:
    [T] [✘] deliver parcel
    You now have 1 task(s) in the list.
 
####Deadline Tasks
Format for *Deadline* tasks: 

`deadline (description) /by (date)`
 
Example of *Deadline* usage:
 
`deadline finish assignment /by Monday`
 
Expected outcome:

    Ok! I've added the following task:
    [D] [✘] finish assignment (by: Monday)
    You now have 2 task(s) in the list.
 
####Event Tasks
Format for *Event* tasks: 

`event (description) /at (date)`
 
Example of *Event* usage:
 
`event consultation /at Tuesday 8am`
 
Expected outcome:

    Ok! I've added the following task:
    [E] [✘] consultation (at: Tuesday 8am)
    You now have 3 task(s) in the list.
 
### 2. List Tasks
Users can use this command to see their list of tasks.

Format to *List* tasks: 

`list`
 
Example of *List* usage:
 
`list`
 
Expected outcome:

    I've printed your list of tasks below!
    
    1. [T] [✘] deliver parcel
    2. [D] [✘] finish assignment (by: Monday)
    3. [E] [✘] consultation (at: Tuesday 8am)
    
### 3. Mark Tasks as Done
Users can mark their tasks as done when they are complete.

Format to *Mark as Done*: 

`done (task index)`
 
Example of *Mark as Done*:
 
`done 3`
 
Expected outcome:

    Ok! I've marked this task as complete!
    [E] [✓] consultation (at: Tuesday 8am)

### 4. Delete
Users can delete their tasks and remove them from the list.

Format to *Delete* tasks: 

`delete (task index)`
 
Example of *Delete* usage:
 
`delete 2`
 
Expected outcome:

    Alright! I've deleted this task as requested!
    [D] [✘] finish assignment (by: Monday)
    
### 5. Find
Users are able to search for tasks in their list based on a keyword they enter.

Format to *Find* tasks: 

`find (keyword)`
 
Example of *Find* usage:
 
`find Tuesday`
 
Expected outcome:

    I've printed out the tasks that contain 'Tuesday' below!
    
    1. [E] [✓] consultation (at: Tuesday 8am)

### 6. Exit Duke
When users are finished using Duke, they can exit the program.

Format to *Exit* Duke: 

`bye`
 
Example of *Exit* usage:
 
`bye`
 
Expected outcome:

    Bye, see you soon!
