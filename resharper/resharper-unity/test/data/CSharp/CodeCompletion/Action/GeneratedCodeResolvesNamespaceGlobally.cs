// ${COMPLETE_ITEM:private OnJointBreak(float) { ... \}}
using UnityEngine;

// This can cause types in the System namespace to be unresolved
// E.g. void OnJointBreak could be generated as Void OnJointBreak(Single) { ... }
namespace Foo.System.Bar
{
  public class A : MonoBehaviour
  {
    OJB{caret}
  }
}

