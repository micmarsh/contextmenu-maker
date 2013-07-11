// Expose the native API to javascript
forge.contextmenufix = {
    showAlert: function (text, success, error) {
        forge.internal.call('contextmenufix.showAlert', {text: text}, success, error);
    }
};

// Register for our native event
forge.internal.addEventListener("contextmenufix.resume", function () {
	alert("Weclome back!");
});
