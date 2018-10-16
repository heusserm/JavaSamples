# JavaSamples

Code Samples in Java for Selenium WebDriver 3
By Matt Heusser - Matt.Heusser@gmail.com

## Background
These examples use Plain Ol' Java Objects, with a plain Ol' text editor, on a computer with a java compiler, using mac/unix style compile commands, with current dependices in the current working directory.

The dependencies will get out of date. Don't worry, I'll tell you where to get them from.

## Getting Started

If you're in UNIX, just run:

./buildme
./runme

From the current workign directory. Boom. Everything just works.

If you are in windows, change the colons in the classpath to semi-colons and the direction of the slashes. Then change the Sample.java to point to where your chromedriver executable is stored. You may need to make sure buildme and runme are proper batch files, adding a .bat file extension. That should be it.


## Getting Current

I included all the dependencies. Some Hoser (It is okay, I can use that phrase, it's pretty much my last name) is going to point out that these are out of date. Okay.

Basically you'll need the latest chromedriver executable (or name-of-browserdriver executable) and put it in the working directory of the java code.

Here's one place to look:

http://chromedriver.chromium.org/downloads

You'll also want to download the current client bindings, which you can find for java here:

https://www.seleniumhq.org/download/

Unzip them in the working directory. You may need to change the buildme and runme to point to the correct .jar files as the version number changes.
