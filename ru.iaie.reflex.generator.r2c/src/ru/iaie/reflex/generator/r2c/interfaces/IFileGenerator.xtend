package ru.iaie.reflex.generator.r2c.interfaces;

interface IFileGenerator {
	def void prepareForGeneration()
	def String generateVariableDefinitions()
	def String generateConstantDefinitions()
	//def String generateProcessDefinitions()
	def String generateProcessImplementations()
	def String generateIOFiles()
	def String generateProcessVariables()
	def void generatePlatformImplementations()
	def void generateMain()
    def void generateBuildFiles()
}