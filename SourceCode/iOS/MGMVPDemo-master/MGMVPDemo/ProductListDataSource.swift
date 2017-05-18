//
//  ProductListDataSource.swift
//  MGMVPDemo
//
//  Created by Tuan Truong on 4/30/16.
//  Copyright © 2016 Tuan Truong. All rights reserved.
//

import UIKit

class ProductListDataSource: NSObject, UITableViewDataSource {
    var products: [Product]!
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return products.count
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ProductCell", for: indexPath)
        let product = products[indexPath.row]
        cell.textLabel?.text = product.name
        cell.detailTextLabel?.text = String(product.price)
        return cell
    }
}
