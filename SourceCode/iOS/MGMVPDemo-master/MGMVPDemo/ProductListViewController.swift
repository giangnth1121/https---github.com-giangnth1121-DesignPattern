//
//  ProductListViewController.swift
//  MGMVPDemo
//
//  Created by Tuan Truong on 4/30/16.
//  Copyright © 2016 Tuan Truong. All rights reserved.
//

import UIKit

class ProductListViewController: UITableViewController, ProductListView {
    
    var presenter: ProductListViewPresenter!
    var productListDataSource: ProductListDataSource!

    override func viewDidLoad() {
        super.viewDidLoad()

        presenter.showProductList()
    }
    
    func setProductList(_ products: [Product]) {
        productListDataSource = ProductListDataSource()
        productListDataSource.products = products
        tableView.dataSource = productListDataSource
        tableView.reloadData()
    }
}
