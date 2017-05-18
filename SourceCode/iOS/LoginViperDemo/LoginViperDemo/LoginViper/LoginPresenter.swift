//
//  LoginPresenter.swift
//  LoginViperDemo
//
//  Created by Giang Béo  on 5/17/17.
//  Copyright © 2017 Atarshine. All rights reserved.
//

import Foundation

class LoginPresenter: NSObject, LoginEventHandler {
    
    var input : LoginInput?
    var loginVC : LoginViewController?
    
    func login(userName: String?, password: String?) {
        input?.loginInput(userName, password: password)
    }
    
}

extension LoginPresenter : LoginOutput {
    
    func loginOutput(_ result: Bool, message: String) {
        if result {
            // move to next screen
            LoginWireFrame.sharedInstance.presentSuccessViewController()
        } else {
            LoginWireFrame.sharedInstance.presentAlertForLoginView(message)
        }
    }
    
}
