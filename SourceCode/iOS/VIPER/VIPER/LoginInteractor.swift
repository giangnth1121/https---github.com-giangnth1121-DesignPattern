//
//  ShowInteractor.swift
//  VIPER
//
//  Created by  on 12/28/15.
//  Copyright © 2015 com.framgia. All rights reserved.
//

import UIKit

protocol LoginInput {
    func loginInput(_ userName : String?, password : String?)
}

protocol LoginOutput {
    func loginOutput(_ result : Bool, message : String)
}

class LoginInteractor: NSObject, LoginInput {
    
    var output : LoginOutput?
    func loginInput(_ userName: String?, password: String?) {
        if userName == nil {
            output?.loginOutput(false, message: "Please tell me your user name!!!!")
            return
        }
        if password == nil {
            output?.loginOutput(false, message: "Please tell me your password!!!!")
            return
        }
        if userName != DataStore.sharedInstance.user.userName {
            output?.loginOutput(false, message: "User name is not correct")
            return
        }
        if password != DataStore.sharedInstance.user.password {
            output?.loginOutput(false, message: "Password is not correct")
            return
        }
        output?.loginOutput(true, message: "Correct!!!!")
    }
    
}
