//
//  DataStore.swift
//  VIPER
//
//  Created by  on 12/28/15.
//  Copyright © 2015 com.framgia. All rights reserved.
//

import UIKit

class DataStore: NSObject {
   
    var user : UserEntity
    
    override init() {
        user = UserEntity()
        user.userName = "user1"
        user.password = "123456"
    }
    
    class var sharedInstance : DataStore {
        struct Static {
            static let instance : DataStore = DataStore()
        }
        return Static.instance
    }
}
