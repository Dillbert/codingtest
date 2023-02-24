const db = require('../db');

async function getCustomersByRef(customerRef){
    console.log("getCustomerByRef" + customerRef); 
    const rows = await db.query(
      `SELECT * from customer where ref='${customerRef}'`
    );
    return rows; 
}

async function createCustomers(customersArray){
     for(var i=0; i < customersArray.length; i++){
        const rows = await db.query(
            `INSERT INTO 
            customer (ref, name, addrLine1, addrLine2, town, county, country, postCode, createdDate) 
            VALUES('${customersArray[i].ref}', '${customersArray[i].name}',
                '${customersArray[i].addrLine1}','${customersArray[i].addrLine2}',
                '${customersArray[i].town}','${customersArray[i].county}',  
                '${customersArray[i].country}','${customersArray[i].postCode}',
                 '${new Date().toISOString().slice(0, 19).replace('T', ' ')}')`
          );
    }
}

async function getAllCustomers(){
  console.log("getAllCustomera"); 
  const rows = await db.query(
    `SELECT * from customer`
  );
  return rows; 
}

module.exports = {
  createCustomers,
  getCustomersByRef,
  getAllCustomers
}