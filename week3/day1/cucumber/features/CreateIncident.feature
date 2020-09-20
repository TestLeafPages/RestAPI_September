Feature: Create a new Incident

Scenario: Create Incident withOut Body

Given Set the End Point
And Set the Authorization
And Set the ContentType as Json
When Send the request as Post
Then Confirm the response status code is 201