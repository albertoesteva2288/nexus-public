/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.audit.internal.orient;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

import org.sonatype.nexus.common.app.ApplicationDirectories;
import org.sonatype.nexus.common.upgrade.Checkpoints;
import org.sonatype.nexus.orient.DatabaseCheckpointSupport;
import org.sonatype.nexus.orient.DatabaseInstance;

/**
 * Upgrade checkpoint for the "audit" database.
 * 
 * @since 3.1
 */
@Named
@Singleton
@Checkpoints(model = AuditDatabase.NAME)
public class AuditDatabaseCheckpoint
    extends DatabaseCheckpointSupport
{
  @Inject
  public AuditDatabaseCheckpoint(@Named(AuditDatabase.NAME) final Provider<DatabaseInstance> databaseInstance,
                                 final ApplicationDirectories appDirectories)
  {
    super(AuditDatabase.NAME, databaseInstance, appDirectories);
  }
}
