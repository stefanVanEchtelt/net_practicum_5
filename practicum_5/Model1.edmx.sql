
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 06/01/2020 10:51:37
-- Generated from EDMX file: C:\Users\Stefan\source\repos\practicum_5\practicum_5\Model1.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [prac5_db];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_orderorderRegel]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[orderLineSet] DROP CONSTRAINT [FK_orderorderRegel];
GO
IF OBJECT_ID(N'[dbo].[FK_productorderRegel]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[orderLineSet] DROP CONSTRAINT [FK_productorderRegel];
GO
IF OBJECT_ID(N'[dbo].[FK_winkelproduct]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[productSet] DROP CONSTRAINT [FK_winkelproduct];
GO
IF OBJECT_ID(N'[dbo].[FK_klantorder]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[orderSet] DROP CONSTRAINT [FK_klantorder];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[customerSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[customerSet];
GO
IF OBJECT_ID(N'[dbo].[storeSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[storeSet];
GO
IF OBJECT_ID(N'[dbo].[productSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[productSet];
GO
IF OBJECT_ID(N'[dbo].[orderSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[orderSet];
GO
IF OBJECT_ID(N'[dbo].[orderLineSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[orderLineSet];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'customerSet'
CREATE TABLE [dbo].[customerSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [username] nvarchar(max)  NOT NULL,
    [password] nvarchar(max)  NOT NULL,
    [balance] float  NOT NULL
);
GO

-- Creating table 'storeSet'
CREATE TABLE [dbo].[storeSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [name] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'productSet'
CREATE TABLE [dbo].[productSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [name] nvarchar(max)  NOT NULL,
    [price] float  NOT NULL,
    [stock] int  NOT NULL,
    [store_Id] int  NOT NULL
);
GO

-- Creating table 'orderSet'
CREATE TABLE [dbo].[orderSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [date] datetime  NOT NULL,
    [customer_Id] int  NOT NULL
);
GO

-- Creating table 'orderLineSet'
CREATE TABLE [dbo].[orderLineSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [amount] int  NOT NULL,
    [order_Id] int  NOT NULL,
    [product_Id] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [Id] in table 'customerSet'
ALTER TABLE [dbo].[customerSet]
ADD CONSTRAINT [PK_customerSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'storeSet'
ALTER TABLE [dbo].[storeSet]
ADD CONSTRAINT [PK_storeSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'productSet'
ALTER TABLE [dbo].[productSet]
ADD CONSTRAINT [PK_productSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'orderSet'
ALTER TABLE [dbo].[orderSet]
ADD CONSTRAINT [PK_orderSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'orderLineSet'
ALTER TABLE [dbo].[orderLineSet]
ADD CONSTRAINT [PK_orderLineSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [order_Id] in table 'orderLineSet'
ALTER TABLE [dbo].[orderLineSet]
ADD CONSTRAINT [FK_orderorderRegel]
    FOREIGN KEY ([order_Id])
    REFERENCES [dbo].[orderSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_orderorderRegel'
CREATE INDEX [IX_FK_orderorderRegel]
ON [dbo].[orderLineSet]
    ([order_Id]);
GO

-- Creating foreign key on [product_Id] in table 'orderLineSet'
ALTER TABLE [dbo].[orderLineSet]
ADD CONSTRAINT [FK_productorderRegel]
    FOREIGN KEY ([product_Id])
    REFERENCES [dbo].[productSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_productorderRegel'
CREATE INDEX [IX_FK_productorderRegel]
ON [dbo].[orderLineSet]
    ([product_Id]);
GO

-- Creating foreign key on [store_Id] in table 'productSet'
ALTER TABLE [dbo].[productSet]
ADD CONSTRAINT [FK_winkelproduct]
    FOREIGN KEY ([store_Id])
    REFERENCES [dbo].[storeSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_winkelproduct'
CREATE INDEX [IX_FK_winkelproduct]
ON [dbo].[productSet]
    ([store_Id]);
GO

-- Creating foreign key on [customer_Id] in table 'orderSet'
ALTER TABLE [dbo].[orderSet]
ADD CONSTRAINT [FK_klantorder]
    FOREIGN KEY ([customer_Id])
    REFERENCES [dbo].[customerSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_klantorder'
CREATE INDEX [IX_FK_klantorder]
ON [dbo].[orderSet]
    ([customer_Id]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------