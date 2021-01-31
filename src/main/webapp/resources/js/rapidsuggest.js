(function (window, document) {

    function setUp(q) {
        var wrapper = document.createElement('span');

        var qq = q.cloneNode(true); // deep clone of q
        wrapper.appendChild(qq);

        var r = document.createElement('div'); // stores the autocomplete results
        wrapper.appendChild(r);

        q.parentElement.insertBefore(wrapper, q);
        q.parentNode.removeChild(q);


        function displayResults(results) {
            if (results.length === 0) {
                r.style.display = 'none';
                return;
            }

            var i, len;
            var ps = r.getElementsByTagName('p'); // getting current results that need to be removed
            for (i = ps.length - 1; i >=0; i--) {
                ps[i].remove();
            }

            r.style.display = 'block';
            for (i=0, len=results.length; i < len; i++) {
                var p = document.createElement('p');
                p.innerHTML = results[i].suggestion;
                r.appendChild(p);
            }

        }

        function handler() {
            console.log("Handler called. q.value: '" + qq.value + "'");

            var req = new window.XMLHttpRequest();
            req.onreadystatechange = function () {
                if (req.readyState === 4) { // DONE, the operation is complete
                    if (req.status === 200) {
                        var response = JSON.parse(req.responseText);
                        displayResults(response); // [ {}, {}]
                    } else {
                        if (req.status !== 0) {
                            console.warn(req.status, req.responseText);
                            r.style.display = 'none';
                        }
                    }
                }
            };

            var url = location.protocol + '//' + location.host + '/rapidsuggest' + '?q=';
            req.open('GET', url + encodeURIComponent(qq.value.trim()), true);
            req.send();
            console.log("Requested autocomplete for '" + qq.value.trim() + "'");
        }

        qq.addEventListener('input', handler);
    }

    window.RapidSuggest = setUp;

})(window, document);