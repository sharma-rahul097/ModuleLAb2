$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("verification/verify.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Rahul Sharma"
    }
  ],
  "line": 4,
  "name": "Verification of Username password",
  "description": "",
  "id": "verification-of-username-password",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Verification of Valid data",
  "description": "",
  "id": "verification-of-username-password;verification-of-valid-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Open the firefox and lauch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Enter the Valid Data",
  "rows": [
    {
      "cells": [
        "Fields",
        "Values"
      ],
      "line": 9
    },
    {
      "cells": [
        "User Name",
        "Rahul"
      ],
      "line": 10
    },
    {
      "cells": [
        "Password",
        "asd"
      ],
      "line": 11
    },
    {
      "cells": [
        "Confirm Password",
        "asd"
      ],
      "line": 12
    },
    {
      "cells": [
        "First Name",
        "Rahul"
      ],
      "line": 13
    },
    {
      "cells": [
        "Last Name",
        "Sharma"
      ],
      "line": 14
    },
    {
      "cells": [
        "Email",
        "rs9858266@gmail.com"
      ],
      "line": 15
    },
    {
      "cells": [
        "Address",
        "deep puram,aurangabad,Mathura"
      ],
      "line": 16
    },
    {
      "cells": [
        "Phone",
        "7894561239"
      ],
      "line": 17
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User registrattion should be successfull",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDef.open_the_firefox_and_lauch_the_application()"
});
formatter.result({
  "duration": 8416636617,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.enter_the_Valid_Data(DataTable)"
});
formatter.result({
  "duration": 2191647897,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_registrattion_should_be_successfull()"
});
formatter.result({
  "duration": 326818291,
  "status": "passed"
});
});