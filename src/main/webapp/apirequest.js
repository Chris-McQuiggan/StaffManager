function makeRequest(reqType, url, body) {
    let req = new XMLHttpRequest();
    req.onload = function () {

        promises(req);
    }
    req.open(reqType, url);
    req.send(body);
}

function promises(req) {
    const createPromise = new Promise(
        function (res, rej) {
            if (req.status === 200) {
                let result = JSON.parse(req.responseText);
                res(result);
            } else {
                const reason = new Error(req.status);
                rej(reason);
            }
        }
    );

    createPromise
        .then(result => resolved(result))
        .catch(error => rejected(error))

}