package com.junio.navigationcomponent.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.junio.navigationcomponent.R
import com.junio.navigationcomponent.extensions.navigateWithAnimations
import com.junio.navigationcomponent.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authenticationStateEvent.observe(viewLifecycleOwner, { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.Authenticated -> {
                    tvName.text = getString(R.string.profile_text_welcome, viewModel.username)
                }
                is LoginViewModel.AuthenticationState.Unauthenticated ->{
                    findNavController().navigateWithAnimations(R.id.loginFragment)
                }
            }
        })
    }
}
