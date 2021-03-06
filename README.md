**CODE CHALLENGE - DASHBOARD API**
-

**Thought Process**

The Goal has a generic domain and it is opened to interpretation.
Create an API to view Bookings, Itineraries and other relevant information.

My first thought was that the dashboard to present was to give information to a sort of agency about how they are performing.
I approached to it by relatiing the information on the view to something that ShipServ could has been working on.
By researching the website, products & services that ShipServ provides to customers, I found under the Supplier Solutions section, the *Supplier Insight Report*. Then, I watched the *SmartSupplier* demo to get a better understanding of how it works.

By taking this information, I thought that bookings could be associated to buyers requests and itineraries could be linked to Request Deliveries that the supplier has already arranged (*'Quoted & Won'*) with buyers.

The view presents a dashboard for the company (supplier) provided as a parameter on the URL.

Considerations:
  - Spring Boot MVC was used provide the solution.
  - The view is really basic, it just shows the information generated. I do not have much experience on the front-end side and in order to deliver this code challenge on time, I decided to focus on the back-end.
  - The solution is limited scoped. Security framework could have been added, more exceptons handing, more information to show and of course an improved view.
  - The information shown on the view is generated by static data on a mock data source.


*Install*

- mvn package
- java -jar target/dashboard-1.0.0-BUILD-SNAPSHOT.jar

*Run*

http://localhost:8080/dashboard  (company='ShipServ' by default)
http://localhost:8080/dashboard?company=<NAME>