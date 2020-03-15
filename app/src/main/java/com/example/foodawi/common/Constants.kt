package com.homyapplication.common


interface Constants {
    companion object{
        const val USER_IS_VERIFIED = "verified"
        const val USER_DATA = "user"
        const val SERVICE_DETAILS= "service_details"
        const val REQUEST_SPECIFIC_SERVICE= "service_specific"
        const val SERVICE_DETAILS_SHOW_ALL= "all_service_details"
        const val FROM_REGISTER= "from_register"
        const val KEY_LANGUAGE = "language"
        const val USER_TOKEN= "token"
        const val SWITCH_KEY= "switch_key"
        const val SHOW_CASE_SEQUENCE= "show_case_sequence"
        const val ADD_LOCATION= "addLocation"
        const val FIREBASE_TOKEN= "firebase_token"
        const val IS_GUEST = "is_guest"


    }


    interface EXTRA {
        companion object {
            const val EXTRA_IMAGE = "image"
            const val EXTRA_EMAIL = "email"
            const val EXTRA_NAME = "name"
            const val EXTRA_SEARCH_TEXT = "search_text"
            const val EXTRA_PHONE = "phone"
            const val EXTRA_PARENT = "parent"
        }

    }

    interface STATUS {
        companion object {
            const val PASSED_BY_INTRO = "intro"
        }


    }

    interface APP {
        companion object {
            const val GET_PAYMENT = "getPayment"
        }

    }

    interface PERMISSIONS {
        companion object {
            const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100
        }
    }

}

