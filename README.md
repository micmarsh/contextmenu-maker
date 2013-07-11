#Contextmenu Maker

A [native Trigger.IO plugin](https://trigger.io/docs/current/api/native_plugins/index.html) that allows you to create native [context menus](https://developer.android.com/guide/topics/ui/menus.html#context-menu) on android platforms.

##Usage

Use any time you need a context menu, likely after a [longpress](http://stackoverflow.com/questions/2625210/long-press-in-javascript)

####Javascript:
```js
forge.internal.call("contextmenu.show", {
  title: "Select An Item",
  items: [
    "Item One",
    "Item Two",
    "Item Three"
  ]
},function(item) {
  //returns a string of user selection: "Item One", "Item Two", or "Item Three"
  return alert("You selected " + item);
}, function(e) {
  return alert("Error: " + e.message);
});
```

####CoffeeScript:
```coffeescript
forge.internal.call 'contextmenu.show',
  title: "Select An Item"
  items: [
    "Item One"
    "Item Two"
    "Item Three"
  ]
  , (item)->
    alert "You selected #{item}"
  , (e) ->
    alert "Error: #{e.message}"
```

##Compatibility

Tested on Android 2.3.5, 4.0.1, 4.1.1, and 4.2

##License

    Copyright (c) 2013, Fetchnotes Inc.
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:

    1. Redistributions of source code must retain the above copyright notice, this
       list of conditions and the following disclaimer.
    2. Redistributions in binary form must reproduce the above copyright notice,
       this list of conditions and the following disclaimer in the documentation
       and/or other materials provided with the distribution.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
    ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
    WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
    DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
    ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
    (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
    LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
    ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
    SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

    The views and conclusions contained in the software and documentation are those
    of the authors and should not be interpreted as representing official policies,
    either expressed or implied, of the FreeBSD Project.