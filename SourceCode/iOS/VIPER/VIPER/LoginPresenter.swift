//
//  ShowPresenter.swift
//  VIPER
//
//  Created by  on 12/28/15.
//  Copyright © 2015 com.framgia. All rights reserved.
//

import UIKit

class LoginPresenter: NSObject, LoginEventHandler {
    
    var input : LoginInput?
    var loginVC : LoginViewController?
    
    func login(_ userName: String?, password: String?) {
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

