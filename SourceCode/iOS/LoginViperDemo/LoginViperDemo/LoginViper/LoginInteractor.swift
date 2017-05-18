//
//  LoginInteractor.swift
//  LoginViperDemo
//
//  Created by Giang Béo  on 5/17/17.
//  Copyright © 2017 Atarshine. All rights reserved.
//

import Foundation

// Input - Output 
// return result of presenter
// return View
protocol LoginInput {
    func loginInput(_ userName : String?, password : String?)
}

protocol LoginOutput {
    func loginOutput(_ result : Bool, message : String)
}

class LoginInteractor: NSObject, LoginInput {
    
    var output : LoginOutput?
    func loginInput(_ userName: String?, password: String?) {
        if (userName?.isEmpty)! {
            output?.loginOutput(false, message: "Input Username!")
            return
        }
        if (password?.isEmpty)!{
            output?.loginOutput(false, message: "Input Password!")
            return
        }
        if userName != DataStore.sharedInstance.user.userName {
            output?.loginOutput(false, message: "Incorrect Username!")
            return
        }
        if password != DataStore.sharedInstance.user.password {
            output?.loginOutput(false, message: "Incorrect Password!")
            return
        }
        output?.loginOutput(true, message: "Success!!!!")
    }
    
}

