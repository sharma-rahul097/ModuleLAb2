$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featureReset/reset.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Rahul Sharma"
    }
  ],
  "line": 3,
  "name": "Reset functionality on login page of Apllication",
  "description": "",
  "id": "reset-functionality-on-login-page-of-apllication",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verification of reset button",
  "description": "",
  "id": "reset-functionality-on-login-page-of-apllication;verification-of-reset-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Open the firefox and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Enter the Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Reset the credentials",
  "keyword": "Then "
});
formatter.match({
  "location": "StepdDef.open_the_firefox_and_launch_the_application()"
});
formatter.result({
  "duration": 5936873286,
  "status": "passed"
});
formatter.match({
  "location": "StepdDef.enter_the_Username_and_Password()"
});
formatter.result({
  "duration": 417469562,
  "status": "passed"
});
formatter.match({
  "location": "StepdDef.reset_the_credentials()"
});
formatter.result({
  "duration": 199625062,
  "status": "passed"
});
});