__d(function(e,t,a,i){function r(e){var t,a;return a=t=function(t){function a(){var e,t,i,r;babelHelpers.classCallCheck(this,a);for(var n=arguments.length,o=Array(n),l=0;l<n;l++)o[l]=arguments[l];return t=i=babelHelpers.possibleConstructorReturn(this,(e=a.__proto__||Object.getPrototypeOf(a)).call.apply(e,[this].concat(o))),i._updateNavigationProps=function(e){i._childNavigationProps||(i._childNavigationProps={}),e.state.routes.forEach(function(t){var a=i._childNavigationProps[t.key];a&&a.state===t||(i._childNavigationProps[t.key]=(0,s.default)(babelHelpers.extends({},e,{state:t})))})},r=t,babelHelpers.possibleConstructorReturn(i,r)}return babelHelpers.inherits(a,t),babelHelpers.createClass(a,[{key:"componentWillMount",value:function(){this._updateNavigationProps(this.props.navigation)}},{key:"componentWillReceiveProps",value:function(e){this._updateNavigationProps(e.navigation)}},{key:"render",value:function(){return o.default.createElement(e,babelHelpers.extends({},this.props,{childNavigationProps:this._childNavigationProps}))}}]),a}(n.PureComponent),t.displayName="withCachedChildNavigation("+(e.displayName||e.name)+")",a}Object.defineProperty(i,"__esModule",{value:!0}),i.default=r;var n=t(12),o=babelHelpers.interopRequireDefault(n),l=t(416),s=babelHelpers.interopRequireDefault(l)},458);