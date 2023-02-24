const express = require('express');
const router = express.Router();
const controller = require('../services/customer.controller');


router.get('', async function(req, res, next) {
  try {   
    console.log("customer GET by ref", req.get('ref'));
     res.json(await controller.getCustomersByRef(req.get('ref')));
   } catch (err) {
    console.error(`Error while getting customer by ref`, err.message);
    next(err);
  }
});

router.post('', async function(req, res, next) {
  try {   
        res.json(await controller.createCustomers(req.body)); 
    } catch (err) {
    console.error(`Error while posting customers`, err.message);
    next(err);
  }
});


module.exports = router;