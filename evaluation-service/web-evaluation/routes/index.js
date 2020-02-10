const express = require('express');
const router = express.Router();
const axios = require('axios');

axios.defaults.headers.common['Authorization'] = "";
router.get('/', function (req, res, next) {
    res.render('auth', {msg: null});
});

router.post("/auth", function (req, res, next) {
    let params = new URLSearchParams();
    let username = req.body['username'];
    let password = req.body["password"];
    params.append("studentId", username);
    params.append("password", password);
    if (username != null && password != null) {
        axios.post('http://127.0.0.1:8080/service/auth/student', params).then(function (response) {
            if (response.data.code == 200) {
                req.session.token = response.data.data;
                res.redirect("/course");
            } else {
                res.render('auth', {msg: response.data.message});
            }
        })
            .catch(function (error) {
                res.render('auth', {msg: error});
            });
    } else {
        res.render('auth', {msg: null});
    }
})

module.exports = router;
