# cnj-resilience-downstream-b

Simple cloud native java application based on Spring Boot which returns a list of [WatchedItem](src/main/java/group/msg/at/cloud/cloudtrain/core/entity/WatchedItem.java)s for a given user.
The behaviour of the service can be controlled via a [SabotageController](src/main/java/group/msg/at/cloud/cloudtrain/adapter/rest/SabotageController.java) which allows you to apply abnormal behaviour to each invocation.

## Status
![Build status](https://drone.cloudtrain.msgoat.eu/api/badges/msgoat/cnj-resilience-downstream-b/status.svg)

## Release information

Check [changelog](changelog.md) for latest version and release information.
