//
//  DataStore.swift
//  LoginViperDemo
//
//  Created by Giang Béo  on 5/17/17.
//  Copyright © 2017 Atarshine. All rights reserved.
//

import Foundation
class DataStore: NSObject {
    
    var user : UserEntity
    
    override init() {
        user = UserEntity()
        user.userName = "giang"
        user.password = "123456"
    }
    
    class var sharedInstance : DataStore {
        struct Static {
            static let instance : DataStore = DataStore()
        }
        return Static.instance
    }
}
