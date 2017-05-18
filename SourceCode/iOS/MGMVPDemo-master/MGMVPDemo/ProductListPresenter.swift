//
//  ProductListPresenter.swift
//  MGMVPDemo
//
//  Created by Tuan Truong on 4/30/16.
//  Copyright © 2016 Tuan Truong. All rights reserved.
//

import UIKit

class ProductListPresenter: ProductListViewPresenter {
    unowned let view: ProductListView
    let products: [Product]
    
    required init(view: ProductListView, products: [Product]) {
        self.view = view
        self.products = products
    }
    
    func showProductList() {
        self.view.setProductList(self.products)
    }
}
