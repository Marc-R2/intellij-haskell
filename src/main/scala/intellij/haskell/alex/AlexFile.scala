package intellij.haskell.alex

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.{FileType, LanguageFileType}
import com.intellij.psi.FileViewProvider
import icons.HaskellIcons
import javax.swing.Icon

class AlexFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, AlexLanguage.Instance) {

  def getFileType: FileType = {
    AlexFileType.INSTANCE
  }

  override def toString: String = {
    " Alex file"
  }

  override def getIcon(flags: Int): Icon = {
    super.getIcon(flags)
  }
}

object AlexFileType {
  final val INSTANCE = new AlexFileType
}

class AlexFileType extends LanguageFileType(AlexLanguage.Instance) {

  def getName: String = {
    "Alex file"
  }

  def getDescription: String = {
    "Alex source file (Haskell lexer generator)"
  }

  def getDefaultExtension: String = {
    "x"
  }

  def getIcon: Icon = {
    HaskellIcons.HaskellFileLogo
  }
}
