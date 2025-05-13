# Releasing

1. Update version (`VERSION_NAME`) in `gradle.properties`
2. Update version in `README.md`
3. Commit changes ("release vX.X.X") and create tag ("vX.X.X")
4. Push commit and tag to repo
5. Release via `./gradlew publishToMavenCentral --no-configuration-cache`
6. Create GH release