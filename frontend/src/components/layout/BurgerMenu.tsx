
import { JSXElementConstructor, useState } from "react";
import { useNavigate, Link, NavLink, NavigateFunction } from "react-router-dom";
import { Interface } from "readline";
import { URLS } from "../../server_constants";
import { calculateSemester } from "../../util/util";

const ICON_PROPS = {
  WIDTH: "48px",
  HEIGHT: "48px",
  COLOR: "#F00045"
};

const NAV_ITEM_MAP = {
  HOME: "Home",
  REGISTRATIONS: "Meine Anmeldungen",
  SUBJECTS: "Übersicht Wahlpflichtfächer",
  INFO: "Informationen Wahlpflichtfächer",
  LOGOUT: "Abmelden"
};

interface burgerMenuProps {
  /**
   * Name of the page. (e.g. 'home')
   */
   name : string;
  /**
   * Name of the logged in user.
   */
   username : string;
  /**
   * Major of the user. (e.g. IN5)
   */
   major : string;
  /**
   * The RZ name of the student
   */
   preferred_username : string;
  /**
   * Function which logs out the user from the application.
   */
   logout : () => {};
  /**
   * Creation timestamp of the user's RZ account.
   */
   timestamp : string;
}

function BurgerMenu (args : burgerMenuProps) {
  let navigate : NavigateFunction = useNavigate();

  const [menuExpanded, setMenuExpanded] = useState(true);

  const iconClasses : string = menuExpanded
    ? "icon-burger-menu collapsed"
    : "icon-burger-menu";

  const menuClasses : string = menuExpanded
    ? "nav-pills flex-column burger-menu"
    : "nav-pills flex-column burger-menu collapsed";

  const toggleMenu = () => {
    setMenuExpanded(!menuExpanded);
  };

  /**
   * Handle the clicks on a collapsed burger menu item.
   * @param {string} name Name of the burger menu item. (e.g. 'home')
   */
  const handleClick = (name : string) => {
    console.log(`Handle click on icon ${name}!`);
    switch (name) {
      case URLS.HOME:
        navigate("/");
        break;
      case URLS.REGISTRATIONS:
        navigate(`/${URLS.REGISTRATIONS}`);
        break;
      case URLS.SUBJECTS:
        navigate(`/${URLS.SUBJECTS}`);
        break;
      case URLS.INFO:
        navigate(`/${URLS.INFO}`);
        break;
      case URLS.LOGOUT:
        args.logout();
        break;
      default:
        break;
    }
  };

  return (
    <>
      <nav className={menuClasses}>
        {/* burger menu icon */}
        <svg
          className="icon-burger-menu"
          xmlns="http://www.w3.org/2000/svg"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={toggleMenu}
        >
          <path d="M0 0h24v24H0V0z" fill="none" />
          <path d="M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z" />
        </svg>
        {/* account details */}
        {menuExpanded && (
          <>
            <div className="container account-details">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                height="100px"
                viewBox="0 0 24 24"
                width="100px"
                fill={ICON_PROPS.COLOR}
              >
                <path d="M0 0h24v24H0V0z" fill="none" />
                <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zM7.07 18.28c.43-.9 3.05-1.78 4.93-1.78s4.51.88 4.93 1.78C15.57 19.36 13.86 20 12 20s-3.57-.64-4.93-1.72zm11.29-1.45c-1.43-1.74-4.9-2.33-6.36-2.33s-4.93.59-6.36 2.33C4.62 15.49 4 13.82 4 12c0-4.41 3.59-8 8-8s8 3.59 8 8c0 1.82-.62 3.49-1.64 4.83zM12 6c-1.94 0-3.5 1.56-3.5 3.5S10.06 13 12 13s3.5-1.56 3.5-3.5S13.94 6 12 6zm0 5c-.83 0-1.5-.67-1.5-1.5S11.17 8 12 8s1.5.67 1.5 1.5S12.83 11 12 11z" />
              </svg>
              <p>{args.username ? args.username : "Max Mustermann"}</p>
              <p>
                Studiengang:{" "}
                {args.major
                  ? args.major + calculateSemester(args.timestamp)
                  : "IN5"}
              </p>
              <p>
                RZ-Kennung:{" "}
                {args.preferred_username ? args.preferred_username : " "}
              </p>
            </div>
          </>
        )}
        {menuExpanded && (
          <>
            <NavLink
              className={({ isActive }) =>
                isActive
                  ? "nav-link link-primary bg-primary active"
                  : "nav-link link-primary"
              }
              to="/"
              end
            >
              {NAV_ITEM_MAP.HOME}
            </NavLink>
            <NavLink
              className={({ isActive }) =>
                isActive
                  ? "nav-link link-primary bg-primary active"
                  : "nav-link link-primary"
              }
              to={`/${URLS.REGISTRATIONS}`}
            >
              {NAV_ITEM_MAP.REGISTRATIONS}
            </NavLink>
            <NavLink
              className={({ isActive }) =>
                isActive
                  ? "nav-link link-primary bg-primary active"
                  : "nav-link link-primary"
              }
              to={`/${URLS.SUBJECTS}`}
            >
              {NAV_ITEM_MAP.SUBJECTS}
            </NavLink>
            <NavLink
              className={({ isActive }) =>
                isActive
                  ? "nav-link link-primary bg-primary active"
                  : "nav-link link-primary"
              }
              to={`/${URLS.INFO}`}
            >
              {NAV_ITEM_MAP.INFO}
            </NavLink>
            <Link
              className="nav-link link-primary"
              to={`/`}
              onClick={() => args.logout()}
            >
              {NAV_ITEM_MAP.LOGOUT}
            </Link>
          </>
        )}

        {/* home icon */}
        <svg
          className={iconClasses}
          xmlns="http://www.w3.org/2000/svg"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={() => handleClick(URLS.HOME)}
        >
          <path d="M0 0h24v24H0V0z" fill="none" />
          <path d="M12 5.69l5 4.5V18h-2v-6H9v6H7v-7.81l5-4.5M12 3L2 12h3v8h6v-6h2v6h6v-8h3L12 3z" />
        </svg>
        {/* my registrations icon */}
        <svg
          className={iconClasses}
          xmlns="http://www.w3.org/2000/svg"
          enableBackground="new 0 0 24 24"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={() => handleClick(URLS.REGISTRATIONS)}
        >
          <g>
            <rect fill="none" height="24" width="48px" />
            <g>
              <path d="M19,5v14H5V5H19 M19,3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h14c1.1,0,2-0.9,2-2V5C21,3.9,20.1,3,19,3L19,3z" />
            </g>
            <path d="M14,17H7v-2h7V17z M17,13H7v-2h10V13z M17,9H7V7h10V9z" />
          </g>
        </svg>
        {/* list icon */}
        <svg
          className={iconClasses}
          xmlns="http://www.w3.org/2000/svg"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={() => handleClick(URLS.SUBJECTS)}
        >
          <g fill="none">
            <path d="M0 0h24v24H0V0z" />
            <path d="M0 0h24v24H0V0z" opacity=".87" />
          </g>
          <path d="M3 13h2v-2H3v2zm0 4h2v-2H3v2zm0-8h2V7H3v2zm4 4h14v-2H7v2zm0 4h14v-2H7v2zM7 7v2h14V7H7zm-4 6h2v-2H3v2zm0 4h2v-2H3v2zm0-8h2V7H3v2zm4 4h14v-2H7v2zm0 4h14v-2H7v2zM7 7v2h14V7H7z" />
        </svg>
        {/* info icon */}
        <svg
          className={iconClasses}
          xmlns="http://www.w3.org/2000/svg"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={() => handleClick(URLS.INFO)}
        >
          <path d="M0 0h24v24H0V0z" fill="none" />
          <path d="M11 7h2v2h-2zm0 4h2v6h-2zm1-9C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm0 18c-4.41 0-8-3.59-8-8s3.59-8 8-8 8 3.59 8 8-3.59 8-8 8z" />
        </svg>
        {/* logout icon */}
        <svg
          className={iconClasses}
          xmlns="http://www.w3.org/2000/svg"
          enableBackground="new 0 0 24 24"
          height={ICON_PROPS.HEIGHT}
          viewBox="0 0 24 24"
          width={ICON_PROPS.WIDTH}
          fill={ICON_PROPS.COLOR}
          onClick={() => handleClick(URLS.LOGOUT)}
        >
          <g>
            <path d="M0,0h24v24H0V0z" fill="none" />
          </g>
          <g>
            <path d="M17,8l-1.41,1.41L17.17,11H9v2h8.17l-1.58,1.58L17,16l4-4L17,8z M5,5h7V3H5C3.9,3,3,3.9,3,5v14c0,1.1,0.9,2,2,2h7v-2H5V5z" />
          </g>
        </svg>
      </nav>
    </>
  );
}

export default BurgerMenu;
