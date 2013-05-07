/*
 * Copyright (c) 2002-2013, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.mylutece.modules.opensso.authentication;

import fr.paris.lutece.plugins.mylutece.authentication.PortalAuthentication;
import fr.paris.lutece.plugins.mylutece.modules.opensso.service.OpenSSOPlugin;
import fr.paris.lutece.portal.service.security.LuteceUser;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

import java.util.Locale;

import javax.security.auth.login.LoginException;

import javax.servlet.http.HttpServletRequest;


/**
 * The Class provides an implementation of the inherited abstract
 * class PortalAuthentication based on OpenSSO
 */
public class OpenSSOAuthentication extends PortalAuthentication
{
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constants
    private static final String AUTH_SERVICE_NAME = AppPropertiesService.getProperty( "mylutece-opensso.service.name" );

    public OpenSSOAuthentication(  )
    {
        super(  );
    }

    /**
    * Gets the Authentification service name
    * @return The name of the authentication service
    */
    public String getAuthServiceName(  )
    {
        return AUTH_SERVICE_NAME;
    }

    /**
    * Gets the Authentification type
    * @param request The HTTP request
    * @return The type of authentication
    */
    public String getAuthType( HttpServletRequest request )
    {
        return HttpServletRequest.BASIC_AUTH;
    }

    /**
    * This methods checks the login info in the LDAP repository
    *
    * @param strUserName The username
    * @param strUserPassword The password
    * @param request The HttpServletRequest
    *
    * @return A LuteceUser object corresponding to the login
    * @throws LoginException The LoginException
    */
    public LuteceUser login( String strUserName, String strUserPassword, HttpServletRequest request )
        throws LoginException
    {
        Locale locale = request.getLocale(  );

        // TODO Check user's credentials

        // If OK then create OpenSSOUser
        LuteceUser user = new OpenSSOUser( strUserName, this );

        // TODO Fill users attributes
        return user;
    }

    /**
    * This methods logout the user
    * @param user The user
    */
    public void logout( LuteceUser user )
    {
    }

    /**
    * This method returns an anonymous Lutece user
    *
    * @return An anonymous Lutece user
    */
    public LuteceUser getAnonymousUser(  )
    {
        return new OpenSSOUser( LuteceUser.ANONYMOUS_USERNAME, this );
    }

    /**
    * Checks that the current user is associated to a given role
    * @param user The user
    * @param request The HTTP request
    * @param strRole The role name
    * @return Returns true if the user is associated to the role, otherwise false
    */
    public boolean isUserInRole( LuteceUser user, HttpServletRequest request, String strRole )
    {
        // TODO Checks user's roles
        return false;
    }

    /**
     * 
     *{@inheritDoc}
     */
	public String getName()
	{
		return OpenSSOPlugin.PLUGIN_NAME;
	}

	/**
	 * 
	 *{@inheritDoc}
	 */
	public String getPluginName()
	{
		return OpenSSOPlugin.PLUGIN_NAME;
	}
}
